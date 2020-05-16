import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

export class user{
  constructor(
    public userName: string,
    public password: string
  ){}
}

export class key{
  constructor(
    public typeOfKey: string,
    public algorithm: string,
    public keySize: number,
    public uniqueIdentifier: string,
  ){}
}

export class keyPair{
  constructor(
    public typeOfKey: string,
    public algorithm: string,
    public keySize: number,
    public privateKeyUniqueIdentifier: string,
    public publicKeyUniqueIdentifier: string,
    public privateKeyNameValue: string,
    public publicKeyNameValue: string
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

    constructor(private httpClient:HttpClient
      ) { 
  }

  getUsers(){
    return this.httpClient.get<user[]>('http://localhost:8080/users')
  }

  public createKey(key) {
    return this.httpClient.post<key>("http://localhost:8080/createkey", key);
  }

  public createKeyPair(keyPair) {
    return this.httpClient.post<keyPair>("http://localhost:8080/createkeypair", keyPair);
  }

  public getKey(key) {
    return this.httpClient.post("http://localhost:8080/getkey", key, {
      responseType: 'text' 
   });
  }

  public destroyKey(key) {
    return this.httpClient.post("http://localhost:8080/destroykey", key,{
      responseType: 'text' 
   });
  }

  public locateKey(ObjectType: FormData) {
    return this.httpClient.post("http://localhost:8080/locatekey", ObjectType,{
      responseType: 'text' 
   });
  }

  public encrypt(uploadFile: FormData){
    return this.httpClient.post("http://localhost:8080/encrypt", uploadFile, {
      responseType: 'text' 
   });
  }

  public decrypt(uploadFile: FormData){
    return this.httpClient.post("http://localhost:8080/decrypt", uploadFile, {
      responseType: 'text' 
   });
  }
}
