import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface TransformResponse {
  nombreSaisie: number;
  resultat: string;
}

@Injectable({
  providedIn: 'root', // Service global
})
export class KataService {
  private readonly apiUrl = environment.apiUrl; // Utilisation de l'URL configurée

  constructor(private http: HttpClient) {}

  // Méthode pour appeler l'API backend
  transformNumber(number: number): Observable<TransformResponse> {
    return this.http.get<TransformResponse>(`${this.apiUrl}/transform?number=${number}`);
  }
}
