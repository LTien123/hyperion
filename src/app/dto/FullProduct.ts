import { ProductCategoryDto, ProductDetailDto, ProductSubCategoryDto } from "./Product";


export interface FullProduct{
    id:number;
    name: string;
    active: boolean;
    productSubCategoryDtoList: ProductSubCategory[];
}

export interface ProductSubCategory {
    id: number;
    name: string;
    productResponseList: Product[];
  }

  export interface Product {
    id: number;
    name: string;
    price: number;
    weight: number;
    description: string;
    isActive: boolean;
    createdAt: Date | number[];
    updatedAt: Date | number[] | null;
    thumbnailUrl: string;
    thumbnailPublicId: string;
    productSubCategoryDto: ProductSubCategoryDto;
    productCategoryDto: ProductCategoryDto;
    productDetailDtoList: ProductDetailDto[];
  }