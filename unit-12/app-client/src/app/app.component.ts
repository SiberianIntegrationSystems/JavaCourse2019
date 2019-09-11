import {Component} from '@angular/core';

@Component({
             selector: 'app-root',
             templateUrl: './app.component.html',
             styleUrls: ['./app.component.css'],
           })
export class AppComponent {
  links = [{
    label:'Вопросы',
    url:'/questions',
  }, {
    label:'Сессии',
    url: '/sessions',
  }];
}
