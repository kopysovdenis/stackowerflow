import { Component, OnInit} from '@angular/core';
import {Item} from '../../models/item/item.model'
import {ItemService} from "../../service/item/item.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(private itemService: ItemService) {
  }

  ngOnInit(): void {}

  searchInput: string = '';
  items: Item[] = [];
  selectedItem?: Item;
  hasMore: boolean = false;

  displayedColumns: string[] = ['id', 'title'/*, 'creation date', 'is answered', 'author'*/];
  dataSource = new MatTableDataSource<Item>(this.items);



  onSelect(item: Item): void {
    this.selectedItem = item;
    window.open(item.link, "_blank");
  }

  getItems(): void {
    this.itemService.getItems(this.searchInput)
      .subscribe((response) => {
        this.items = response.items
        this.hasMore = response.hasMore
        this.dataSource = new MatTableDataSource<Item>(response.items);
      });
  }

}
