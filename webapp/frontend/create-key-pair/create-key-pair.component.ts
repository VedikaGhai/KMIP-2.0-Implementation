import { Component, OnInit } from '@angular/core';
import {HttpClientService, keyPair} from '../service/http-client-service.service';

@Component({
  selector: 'app-create-key-pair',
  templateUrl: './create-key-pair.component.html',
  styleUrls: ['./create-key-pair.component.css']
})
export class CreateKeyPairComponent implements OnInit {

  Key: keyPair = new keyPair("","",0,"","","","");
  Key1: keyPair = new keyPair("","",0,"","","","");
  
  constructor(
    private httpClientService: HttpClientService
    ) { }

  ngOnInit() {
  }

  createKeyPair(){
    console.log(this.Key);

    this.httpClientService.createKeyPair(this.Key)
        .subscribe( data => {
          this.Key1 = data;
          console.log(this.Key1);
          this.Key1.privateKeyUniqueIdentifier = "PrivateKey Unique Identifier : "+this.Key1.privateKeyUniqueIdentifier;
          this.Key1.publicKeyUniqueIdentifier = "PublicKey Unique Identifier : "+this.Key1.publicKeyUniqueIdentifier;
        });
  }

}
