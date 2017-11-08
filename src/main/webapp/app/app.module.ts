import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ng2-webstorage';

import { FamilyTreeJHipsterSharedModule, UserRouteAccessService } from './shared';
import { FamilyTreeJHipsterHomeModule } from './home/home.module';
import { FamilyTreeJHipsterAdminModule } from './admin/admin.module';
import { FamilyTreeJHipsterAccountModule } from './account/account.module';
import { FamilyTreeJHipsterEntityModule } from './entities/entity.module';

import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

// jhipster-needle-angular-add-module-import JHipster will add new module here

import {
    JhiMainComponent,
    LayoutRoutingModule,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ActiveMenuDirective,
    ErrorComponent
} from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        LayoutRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        FamilyTreeJHipsterSharedModule,
        FamilyTreeJHipsterHomeModule,
        FamilyTreeJHipsterAdminModule,
        FamilyTreeJHipsterAccountModule,
        FamilyTreeJHipsterEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class FamilyTreeJHipsterAppModule {}
