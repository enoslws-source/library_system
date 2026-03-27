import {Component} from "@angular/core";
import {CommonModule} from "@angular/common";
import  {MainScreenService} from './services/main-screen.service';
import {ActivatedRoute} from '@angular/router';
import {inject} from "@angular/core";


@Component ({
    templateUrl: './app.bookdetail.html',
    standalone: true,
    imports: [CommonModule]

})

export class BookDetailComponent {

    private route = inject(ActivatedRoute);
    private mainScreenService = inject(MainScreenService); // this creates instance of component and allows us to use it. This way we can use methods in it
    tempbookId: string | null = null;
    book: any = null; // declares a variable we will store the JSON book object in


    constructor() {

        this.tempbookId = this.route.snapshot.paramMap.get('id'); // this gets the books id from the url that was on the clickable

        if(this.tempbookId == null){ // checks if the value is null from the id
            console.error(); // logs a message to dev console; useful in debugging
        } else {
            const bookId: number = +this.tempbookId; // this forces ts to convert string to a number, ts doesnt use longs
            this.mainScreenService.getBook(bookId).subscribe( // uses the injected method from mss, getBook and activates the method in it using the.subscribe
               data => { // this is saying there is a data object coming from backend
                   this.book = data; // we are setting the book variable to whatver came back from the backend which was "data"
               });
            }
        }

}
