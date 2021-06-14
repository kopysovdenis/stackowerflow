import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TableComponent } from './component/table/table.component';
import { ItemsComponent } from './component/items/items.component';
import { ItemDetailComponent } from './component/item-detail/item-detail.component';
import { HttpClientModule } from '@angular/common/http';
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    ItemsComponent,
    ItemDetailComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
