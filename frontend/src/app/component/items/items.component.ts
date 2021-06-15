import {Component, OnInit} from '@angular/core';
import {Item} from '../../models/item/item.model'
import {ItemService} from "../../service/item/item.service";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(private itemService: ItemService) {
  }

  searchInput: string = '';
  items: Item[] = [];
  selectedItem?: Item;
  hasMore: boolean = false;

  ngOnInit(): void {
    // this.getItems(this.searchInput);
  }

  onSelect(item: Item): void {
    this.selectedItem = item;
    window.open(item.link, "_blank");
  }

  getItems(): void {
    this.itemService.getItems(this.searchInput)
      .subscribe((response) => {
        this.items = response.items
        this.hasMore = response.hasMore
      });
  }

}
