import { Component, OnInit } from '@angular/core';
import {HttpClientService, key} from '../service/http-client-service.service';

@Component({
  selector: 'app-create-key',
  templateUrl: './create-key.component.html',
  styleUrls: ['./create-key.component.css']
})
export class CreateKeyComponent implements OnInit {

  Key: key = new key("","",0,"");
  Key1: key = new key("","",0,"");
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  createKey(){
    console.log(this.Key);

    this.httpClientService.createKey(this.Key)
        .subscribe( data => {
          this.Key1 = data;
          console.log(this.Key1);
          this.Key1.uniqueIdentifier = "UniqueIdentifier : "+this.Key1.uniqueIdentifier;
        });
  }

}
