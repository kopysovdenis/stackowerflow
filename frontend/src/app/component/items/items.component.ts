import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Item} from '../../models/item/item.model'
import {ItemService} from "../../service/item/item.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {catchError, tap} from "rxjs/operators";
import {SearchResponseModel} from "../../models/item/search.response.model";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit, AfterViewInit {



  searchInput: string = '';
  items: Item[] = [];
  selectedItem?: Item;
  hasMore: boolean = false;

  length: number = 0;
  pageIndex: number = 1;
  pageSize: number = 10;
  pageSizeOptions: number[] = [10, 25, 100];

  isLoadingResults = false;

  displayedColumns: string[] = ['created', 'title', 'responses', 'author'];
  dataSource = new MatTableDataSource<Item>(this.items);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private itemService: ItemService) {
  }

  ngOnInit(): void {}

  ngAfterViewInit(): void {
  }

  onSelect(item: Item): void {
    this.selectedItem = item;
    window.open(item.link, "_blank");
  }

  getItems(): void {
    this.isLoadingResults = true;
    this.itemService.getItems(this.searchInput, this.paginator.pageIndex + 1, this.paginator.pageSize)
      .subscribe((response) => {
        this.isLoadingResults = false;
        this.items = response.items
        this.hasMore = response.hasMore
        this.pageIndex = this.paginator.pageIndex + 1;
        this.pageSize = this.paginator.pageSize;
        this.length = response.quotaRemaining;
        this.dataSource = new MatTableDataSource<Item>(response.items);
      });
  }

  callback(event: PageEvent): void {
    console.log(event);
    this.getItems();
  }
}
