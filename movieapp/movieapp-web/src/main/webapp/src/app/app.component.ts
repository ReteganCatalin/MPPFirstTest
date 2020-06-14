import { Component } from '@angular/core';
import {Router} from '@angular/router';
import { HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Rental Shop';

  constructor( private router: Router) { }

  // tslint:disable-next-line:use-life-cycle-interface
  ngOnInit(): void {
  }

}
