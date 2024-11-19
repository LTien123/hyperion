import { ProductColorDto, ProductHandlebarDto, ProductMaterialDto } from "./Product";

export interface ProductDetail {
    id: number;
    stock: number;
    productDto: ProductDto;
    productColorDto: ProductColorDto;
    productHandlebarDto: ProductHandlebarDto | null;
    productMaterialDto: ProductMaterialDto | null;
    productImageResponseList: ProductImageResponse[];
    active: boolean;
}

export interface ProductImageResponse {
    id: number;
    url: string;
    publicId: string;
    productDetailId: number;
}

export interface ProductDto {
    id: number;
    name: string;
    price:number;
}