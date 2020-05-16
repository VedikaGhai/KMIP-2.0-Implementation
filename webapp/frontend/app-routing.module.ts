import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user/user.component';
import { EncryptComponent } from './encrypt/encrypt.component';
import { CreateKeyComponent } from './create-key/create-key.component';
import { GetKeyComponent } from './get-key/get-key.component';
import { DestroyKeyComponent } from './destroy-key/destroy-key.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { CreateKeyPairComponent } from './create-key-pair/create-key-pair.component';
import { LocateKeyComponent } from './locate-key/locate-key.component';
import { DecryptComponent } from './decrypt/decrypt.component';

const routes: Routes = [
  { path:'',component: UserComponent},
  { path:'encrypt', component: EncryptComponent, canActivate:[AuthGaurdService]},
  { path:'decrypt', component: DecryptComponent, canActivate:[AuthGaurdService]},
  { path:'createkey', component: CreateKeyComponent, canActivate:[AuthGaurdService]},
  { path:'getkey', component: GetKeyComponent, canActivate:[AuthGaurdService]},
  { path:'destroykey', component: DestroyKeyComponent, canActivate:[AuthGaurdService]},
  { path:'logout', component: LogoutComponent, canActivate:[AuthGaurdService]},
  { path:'createkeypair', component: CreateKeyPairComponent, canActivate:[AuthGaurdService]},
  { path:'locatekey', component: LocateKeyComponent, canActivate:[AuthGaurdService]},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
