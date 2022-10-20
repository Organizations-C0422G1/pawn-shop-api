import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompleteContractComponent } from './complete-contract/complete-contract.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { LiquidationContractComponent } from './liquidation-contract/liquidation-contract.component';
import { ExpectedContractComponent } from './expected-contract/expected-contract.component';

@NgModule({
  declarations: [
    AppComponent,
    CompleteContractComponent,
    LiquidationContractComponent,
    ExpectedContractComponent
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
