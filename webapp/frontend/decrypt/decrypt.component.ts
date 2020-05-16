import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client-service.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-decrypt',
  templateUrl: './decrypt.component.html',
  styleUrls: ['./decrypt.component.css']
})
export class DecryptComponent implements OnInit {

  uniqueIdentifier: string;
  ciphertextFile: File;
  plaintext: string;
  filename: string;
  
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  selectFile(event){
    this.ciphertextFile = event.target.files[0];
    this.filename = this.ciphertextFile.name;
  }
  decryptFile(){
    //console.log(this.plaintextFile);
    //console.log(this.uniqueIdentifier);

    const uploadFile = new FormData();
    uploadFile.append('ciphertextFile', this.ciphertextFile);
    uploadFile.append('uniqueIdentifier', this.uniqueIdentifier);

    //console.log(uploadFile.getAll);    
    console.log(uploadFile);

    this.httpClientService.decrypt(uploadFile).subscribe(
      (response)=>{
        this.plaintext= response;
        console.log(this.plaintext);
        }
    );

  }

  downloadFile(){

    //for using saveAs, install file-saver
    //npm install angular-file-saver

   this.filename = "decrypted-"+this.filename;    
   //console.log(this.ciphertext);
   var data = new Blob([this.plaintext], { type: 'text/plain' });
   saveAs(data, this.filename);
  }

}
