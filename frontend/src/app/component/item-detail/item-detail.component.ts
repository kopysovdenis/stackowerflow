import { Component, OnInit, Input } from '@angular/core';
import { Item } from "../../models/item/item.model";

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {

  @Input() item?: Item;

  constructor() { }

  ngOnInit(): void {
  }

}
