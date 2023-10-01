import { Cars } from "./cars";

export class Image {
    id?: number;
    fileName?: string;
    fileType?: string;
    // data?: number[];
    data?: Blob;
    cars?: Cars;
}