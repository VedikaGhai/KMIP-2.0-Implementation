import { Component, OnInit } from '@angular/core';
import {HttpClientService, key} from '../service/http-client-service.service';

@Component({
  selector: 'app-destroy-key',
  templateUrl: './destroy-key.component.html',
  styleUrls: ['./destroy-key.component.css']
})
export class DestroyKeyComponent implements OnInit {

  Key: key = new key("","",0,"");
  ResultStatus: string;
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  destroyKey(){
    console.log("Destroy Key clicked");
    console.log(this.Key);
    this.httpClientService.destroyKey(this.Key)
        .subscribe( data => {
          this.ResultStatus = data;
          console.log(this.ResultStatus);
          this.ResultStatus = "Key destroyed : "+this.ResultStatus;
        });
  
  }

}
