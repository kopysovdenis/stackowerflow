import { Component, OnInit} from '@angular/core';
import {Item} from '../../models/item/item.model'
import {ItemService} from "../../service/item/item.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {catchError, tap} from "rxjs/operators";
import {SearchResponseModel} from "../../models/item/search.response.model";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {



  searchInput: string = '';
  items: Item[] = [];
  selectedItem?: Item;
  hasMore: boolean = false;
  isLoadingResults = false;

  displayedColumns: string[] = ['created', 'title', /*, 'is answered', 'author'*/];
  dataSource = new MatTableDataSource<Item>(this.items);

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {}



  onSelect(item: Item): void {
    this.selectedItem = item;
    window.open(item.link, "_blank");
  }

  getItems(): void {
    this.isLoadingResults = true;
    this.itemService.getItems(this.searchInput)
      .subscribe((response) => {
        this.isLoadingResults = false;
        this.items = response.items
        this.hasMore = response.hasMore
        this.dataSource = new MatTableDataSource<Item>(response.items);
      });
  }

}
