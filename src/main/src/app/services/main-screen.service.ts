import { Injectable} from '@angular/core';
import {HttpClient} from  '@angular/common/http';
import  { Observable} from 'rxjs';

@Injectable ({
    providedIn: 'root'
})

export class MainScreenService {
    private apiUrl = 'http://localhost:8080/api/mainscreen';

    constructor(private http: HttpClient){}

    getAllBooks(): Observable<any[]> {
        return this.http.get<any[]> (this.apiUrl);
    }

    getBook(id: number): Observable<any> { // this is declaring a method with a paramter of string for the id and will return any data type, which will be a book when something subsribes to it // obserable tells ts what the return type will be
        return this.http.get<any> (`${this.apiUrl}/${id}`); // this is appending the string dynamically and adding the id when getbook is called so it can get whatver book is clicked using the backticks and the braces
    }
}