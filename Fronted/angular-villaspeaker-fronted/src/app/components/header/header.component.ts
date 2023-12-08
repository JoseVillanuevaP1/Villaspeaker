import { Component, OnInit } from '@angular/core';
declare var $: any;

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent implements OnInit {

  firstname: string = 'Villa'
  secondname: string = 'Speaker'


  ngOnInit(): void {
    
  }
}
