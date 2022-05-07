import { Component, OnInit } from '@angular/core';

import { ProvidersService } from 'src/app/services/providers.service'

@Component({
  selector: 'app-providers',
  templateUrl: './providers.component.html',
  styleUrls: ['./providers.component.css']
})
export class ProvidersComponent implements OnInit {

  constructor(private service: ProvidersService) { }

  ngOnInit(): void {

    this.service.list().subscribe(data => {
      console.log(data)
    })
  }

}
