import { Component, OnInit } from '@angular/core';
import {HttpClientService, user} from '../service/http-client-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users:user[];
  username: string;
  password: string;
  loginDetails: user;
  authenticUser: boolean;

  constructor(
    private httpClientService:HttpClientService, private router: Router
  ) { }

  ngOnInit() {
    this.httpClientService.getUsers().subscribe(response=>this.handleSuccessfulResponse(response));
    this.authenticUser=false;
  }

  handleSuccessfulResponse(response)
{
    this.users=response;
    //console.log(this.users);

}

checkLogin(){
  //console.log(this.username);
  //console.log(this.password);
  for (let index = 0; index < this.users.length; index++) {
    var uname = this.users[index].userName;
    var pwd = this.users[index].password;
    if(uname===this.username && pwd===this.password)
    {
        this.authenticUser= true;
        break;
    }
  }
  //window.alert(this.authenticUser);
  if(this.authenticUser===false)
  {
    window.alert("Invalid username or password!");
    this.username="";
    this.password="";
  }
  if(this.authenticUser===true)
  {
    this.router.navigate(['/createkey']);
    sessionStorage.setItem('username',this.username);
  }
}
}
