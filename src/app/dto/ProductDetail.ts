import { ProductColorDto, ProductHandlebarDto, ProductMaterialDto } from "./Product";

export interface ProductDetail {
    id: number;
    stock: number;
    productDto: ProductDto;
    productColorDto: ProductColorDto;
    productHandlebarDto: ProductHandlebarDto;
    productMaterialDto: ProductMaterialDto;
    productImageResponseList: ProductImageResponse[];
    active: boolean;
}

export interface ProductImageResponse {
    id: string;
    url: string;
    publicId: string;
    productDetailId: number;
}

export interface ProductDto {
    id: number;
    name: string;
    price:number;
}