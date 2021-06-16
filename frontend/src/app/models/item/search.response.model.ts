import {Item} from "./item.model";

export interface SearchResponseModel {
  items: Item[];
  has_more: boolean;
  quota_max: number;
  quota_remaining: number;
}
