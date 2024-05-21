import express, { Application, Request, Response, NextFunction } from 'express';
import morgan from 'morgan';
import dotenv from 'dotenv';
import { Signale } from 'signale';
import proxy from 'express-http-proxy';

const app: Application = express();
const signale = new Signale();

dotenv.config();

app.use(morgan('dev'));

const PORT = process.env.PORT || 3000;
const GATEWAY = process.env.SERVICE_NAME;

app.use((req: Request, res: Response, next: NextFunction) => {
    console.log(`Received request: ${req.method} ${req.url}`);
    next();
});

app.use('/api/v1/orders', proxy('http://localhost:3001'));
app.use('/api/v1/productos', proxy('http://localhost:3002'));

app.use((err: any, req: Request, res: Response, next: NextFunction) => {
    console.error(`Error occurred: ${err.message}`);
    res.status(500).send('Internal Server Error');
});

app.listen(PORT, () => {
    signale.success(`Servicio ${GATEWAY} corriendo en http://localhost:${PORT}`);
});
