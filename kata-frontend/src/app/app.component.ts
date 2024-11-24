import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { CommonModule } from '@angular/common';
import { KataService, TransformResponse } from './services/kata.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule], 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  inputNumber: number | null = null; // Nombre saisi
  result: string = ''; // Résultat renvoyé par l'API
  errorMessage: string = ''; // Message d'erreur

  constructor(private kataService: KataService) {}

  transformNumber(): void {
    if (this.inputNumber === null || this.inputNumber < 0 || this.inputNumber > 100) {
      this.resetInput();
      this.errorMessage = 'Veuillez entrer un nombre entre 0 et 100.';
      return;
    }

    this.errorMessage = ''; // Réinitialiser le message d'erreur
    this.result = ''; // Réinitialiser le résultat

    // Appel au service pour transformer le nombre
    this.kataService.transformNumber(this.inputNumber).subscribe({
      next: (response: TransformResponse) => {
        this.result = `Nombre saisi: ${response.nombreSaisie}, Résultat: ${response.resultat}`;
      },
      error: () => {
        this.errorMessage = 'Erreur lors de la communication avec le backend.';
      },
    });
  }

    // Méthode pour réinitialiser les valeurs
    resetInput(): void {
      this.inputNumber = null; // Réinitialise le champ de saisie
      this.result = '';        // Réinitialise le résultat
      this.errorMessage = '';  // Réinitialise les messages d'erreur
    }
}
