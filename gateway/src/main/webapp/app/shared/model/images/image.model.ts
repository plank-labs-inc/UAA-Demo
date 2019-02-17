import { Moment } from 'moment';

export interface IImage {
    id?: number;
    desc?: string;
    created?: Moment;
}

export class Image implements IImage {
    constructor(public id?: number, public desc?: string, public created?: Moment) {}
}
