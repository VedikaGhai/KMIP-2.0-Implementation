import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import {HttpClientModule} from '@angular/common/http';
import { EncryptComponent } from './encrypt/encrypt.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CreateKeyComponent } from './create-key/create-key.component';
import { GetKeyComponent } from './get-key/get-key.component';
import { DestroyKeyComponent } from './destroy-key/destroy-key.component';
import { LogoutComponent } from './logout/logout.component';
import { CreateKeyPairComponent } from './create-key-pair/create-key-pair.component';
import { LocateKeyComponent } from './locate-key/locate-key.component';
import { DecryptComponent } from './decrypt/decrypt.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    EncryptComponent,
    HeaderComponent,
    FooterComponent,
    CreateKeyComponent,
    GetKeyComponent,
    DestroyKeyComponent,
    LogoutComponent,
    CreateKeyPairComponent,
    LocateKeyComponent,
    DecryptComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
