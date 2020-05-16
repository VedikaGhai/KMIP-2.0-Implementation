import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client-service.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-encrypt',
  templateUrl: './encrypt.component.html',
  styleUrls: ['./encrypt.component.css']
})
export class EncryptComponent implements OnInit {
  
  uniqueIdentifier: string;
  plaintextFile: File;
  ciphertext: string;
  filename: string;
  
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(){
  }

  selectFile(event){
    this.plaintextFile = event.target.files[0];
    this.filename = this.plaintextFile.name;
  }
  encryptFile(){
    //console.log(this.plaintextFile);
    //console.log(this.uniqueIdentifier);

    const uploadFile = new FormData();
    uploadFile.append('plaintextFile', this.plaintextFile);
    uploadFile.append('uniqueIdentifier', this.uniqueIdentifier);

    //console.log(uploadFile.getAll);    
    console.log(uploadFile);

    this.httpClientService.encrypt(uploadFile).subscribe(
      (response)=>{
        this.ciphertext= response;
        console.log(this.ciphertext);
        }
    );

  }

  downloadFile(){

    //for using saveAs, install file-saver
    //npm install angular-file-saver

   this.filename = "encrypted-"+this.filename;    
   //console.log(this.ciphertext);
   var data = new Blob([this.ciphertext], { type: 'text/plain' });
   saveAs(data, this.filename);
  }
}
