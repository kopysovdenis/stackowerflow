import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {catchError, tap} from "rxjs/operators";
import {SearchResponseModel} from "../../models/item/search.response.model";

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  constructor(private http: HttpClient) {
  }

  private searchUrl = 'http://localhost:8090/api/search';

  getItems(intitle: string = '', page: number = 1,  pagesize: number = 10): Observable<SearchResponseModel> {
    return this.http.get<SearchResponseModel>(this.searchUrl, {params: {
      intitle,
        page,
        pagesize
    }}).pipe(
      tap(_ => this.log('fetched SearchResponseModel')),
      catchError(this.handleError<SearchResponseModel>('getItems', undefined))
    );
  }

  private log(message: string) {
    console.log(message)
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }
}
