import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import  {MainScreenService} from './services/main-screen.service';

@Component ({
    selector: 'app-root',
    templateUrl: './app.component.html',
    standalone: true,
    imports: [CommonModule]
})


export class AppComponent implements OnInit {
    books: any[] = [];
    book: any;


    constructor(
        private mainScreenService: MainScreenService,
        private cdr: ChangeDetectorRef) {}


    ngOnInit(): void {
        this.loadBooks();
    }

    loadBooks(): void {
    this.mainScreenService.getAllBooks().subscribe ({
            next: (data: any[]) => {
                this.books = data;
                this.cdr.detectChanges();
                console.log('Books received', data);
            },
            error: (err: any) => {
                console.error('Error loading books: ', err);
            }
        }

    );
    }
}