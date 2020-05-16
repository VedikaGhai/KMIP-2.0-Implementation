import { Component, OnInit } from '@angular/core';
import {HttpClientService, key} from '../service/http-client-service.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-get-key',
  templateUrl: './get-key.component.html',
  styleUrls: ['./get-key.component.css']
})
export class GetKeyComponent implements OnInit {

  Key: key = new key("","",0,"");
  Key1: string;
  filename: string;
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  getKey(){
    console.log("Get Key clicked");
    console.log(this.Key);

    this.httpClientService.getKey(this.Key)
        .subscribe( data => {
          this.Key1 = data;
          console.log(this.Key1);
        });
  }

  downloadFile(){

    //for using saveAs, install file-saver
    //npm install angular-file-saver

    this.filename = "KeyBlock.txt";    
    //console.log(this.ciphertext);
    var data = new Blob([this.Key1], { type: 'text/plain' });
    saveAs(data, this.filename);

  }
}
