import { Component, OnInit } from '@angular/core';
import { Item } from '../../models/item/item.model'
import {ItemService} from "../../service/item/item.service";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(private itemService: ItemService) { }

  items: Item[] = [];
  selectedItem?: Item;
  hasMore: boolean = false;

  ngOnInit(): void {
    this.getItems();
  }

  onSelect(item: Item): void {
    this.selectedItem = item;
  }

  getItems(): void {
    const inTitle = 'java';
    this.itemService.getItems(inTitle)
      .subscribe((response) => {
        this.items = response.items
        this.hasMore = response.hasMore
      });
  }

}
