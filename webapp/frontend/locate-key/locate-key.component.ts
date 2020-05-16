import { Component, OnInit } from '@angular/core';
import {HttpClientService} from '../service/http-client-service.service';

@Component({
  selector: 'app-locate-key',
  templateUrl: './locate-key.component.html',
  styleUrls: ['./locate-key.component.css']
})
export class LocateKeyComponent implements OnInit {

  ObjectType: string;
  UniqueIdentifier: string;
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  locateKey()
  {
    console.log("Locate Key clicked");
    console.log(this.ObjectType);
    
    const requestParams = new FormData();
    requestParams.append("ObjectType", this.ObjectType);
    console.log(requestParams);

    this.httpClientService.locateKey(requestParams)
        .subscribe( data => {
          this.UniqueIdentifier = data;
          console.log(this.UniqueIdentifier);
          this.UniqueIdentifier = "Unique Identifiers : "+this.UniqueIdentifier;
        });
  
  }
}
