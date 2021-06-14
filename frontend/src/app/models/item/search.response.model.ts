import {Item} from "./item.model";

export interface SearchResponseModel {
  items: Item[];
  hasMore: boolean;
  quotaMax: number;
  quotaRemaining: number;
}
