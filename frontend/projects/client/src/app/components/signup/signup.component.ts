import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  user = {
    username: '',
    email: '',
    password: '',
    acceptedTermsAndConditions: false,
    address: {
      street: '',
      city: '',
      state: '',
      zipcode: '',
      country: ''
    }
  };
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) { }

  onSubmit() {
    this.authService.signup(this.user).subscribe({
      next: (response) => {
        if (typeof response === 'string' && response.toLowerCase().includes('error')) {
          this.errorMessage = response;
          alert(response);
        } else {
          console.log('Signup successful', response);
          alert('Signup Successful! Please login.');
          this.router.navigate(['/login']);
        }
      },
      error: (err) => {
        if (err.status === 0) {
          this.errorMessage = 'Cannot connect to backend. Is the server running?';
        } else {
          this.errorMessage = 'Signup failed. ' + (err.error?.message || err.statusText || 'Unknown Error');
        }
        console.error(err);
      }
    });
  }
}
