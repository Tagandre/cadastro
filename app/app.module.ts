import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpModule} from "@angular/http";
import {ConfigService} from "./services/config.service";

import {AlunoService} from "./services/aluno.service"
import {GrupoAlunoService} from "./services/grupo-aluno.service";
import {GrupoService} from "./services/grupo.service";
import {FuncionarioService} from "./services/funcionario.service";
import {CategoriaService} from "./services/categoria.service";
import {CursoService} from "./services/curso.service";
import {MenuComponent} from "./menu/menu.component";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {ConsultaComponent} from "./aluno/consulta/consulta.component";
import {CadastroComponent} from "./aluno/cadastro/cadastro.component";
import {FormsModule} from "@angular/forms";
import {routing} from "../aoo.routes";
import {MatSliderModule} from "@angular/material/slider";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CursoComponent} from "./curso/curso.component";
import {CategoriaComponent} from "./categoria/categoria.component";
import {CadastroFuncionarioComponent} from "./funcionario/cadastro/cadastro-funcionario.component";
import {ConsultaFuncionarioComponent} from "./funcionario/consulta/consulta-funcionario.component";
import {CadastroGrupoComponent} from "./grupo/cadastro/cadastro-grupo.component";
import {ConsultaGrupoComponent} from "./grupo/consulta/consulta-grupo.component";
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {UsuarioService} from "./services/usuario.service";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {GrupoAlunoComponent} from "./grupoAluno/grupoAluno.component";
import {LoginModule} from "./autenticacao/login/login.module";
import {AppRoutingModule} from "./app-routing.module";
import {LogarComponent} from "./autenticacao/login/components/logar.component";
import {LoginRoutingModule} from "./autenticacao/login/login-routing.module";
import {MatInputModule} from "@angular/material/input";
import {MatListModule} from "@angular/material/list";
import {MatTooltipModule} from "@angular/material/tooltip";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { ReactiveFormsModule } from '@angular/forms';
import {MatExpansionModule} from "@angular/material/expansion";


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    MenuComponent,
    HomeComponent,
    ConsultaComponent,
    CadastroComponent,
    CursoComponent,
    CategoriaComponent,
    CadastroFuncionarioComponent,
    ConsultaFuncionarioComponent,
    CadastroGrupoComponent,
    ConsultaGrupoComponent,
    GrupoAlunoComponent,
    LogarComponent,
  ],
    imports: [
        BrowserModule,
        HttpModule,
        RouterModule,
        FormsModule,
        MatSliderModule,
        routing,
        MatFormFieldModule,
        MatIconModule,
        BrowserAnimationsModule,
        MatButtonModule,
        MatSelectModule,
        MatCheckboxModule,
        LoginModule,
        LoginRoutingModule,
        MatInputModule,
        MatButtonModule,
        MatListModule,
        MatTooltipModule,
        MatIconModule,
        MatSnackBarModule,
        ReactiveFormsModule,

        //sempre por ultimo
        AppRoutingModule,
        MatExpansionModule

    ],
  providers: [
    ConfigService,
    AlunoService,
    CategoriaService,
    CursoService,
    GrupoService,
    GrupoAlunoService,
    FuncionarioService,
    UsuarioService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
