import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
import { AuthorServiceService } from '../author-service.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  authors: Observable<AuthorComponent[]>;
  defaultSearch = "Pascal Poizat" ;
  constructor(private authorsService: AuthorServiceService,
    private router: Router) {}


  ngOnInit() {
    this.getAuthorByName(this.defaultSearch);
  }

  getAuthorByName(name: string) {
    this.authors = this.authorsService.getAuthor(name);
    console.log(this.authors);
  }

}
