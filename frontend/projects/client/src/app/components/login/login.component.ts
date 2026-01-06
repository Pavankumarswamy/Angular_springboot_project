import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials = { email: '', password: '' };
  errorMessage = '';
  users: any[] = [];

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers() {
    this.authService.getAllUsers().subscribe({
      next: (data) => {
        this.users = data;
        console.log('Users fetched', this.users);
      },
      error: (err) => {
        console.error('Failed to fetch users', err);
      }
    });
  }

  /* ... existing code ... */
  showEditModal = false;
  editingUser: any = { email: '', username: '', address: { city: '', country: '' } };

  /* ... existing constructor and ngOnInit ... */

  deleteUser(email: string) {
    if (confirm('Are you sure you want to delete this user?')) {
      this.authService.deleteUser(email).subscribe({
        next: (response) => {
          // Check if response indicates success
          if (typeof response === 'string' && response.includes('deleted successfully')) {
            this.users = this.users.filter(u => u.email !== email);
            alert(response);
          } else {
            // Handle "not found" or "error" returned as 200 OK text
            console.warn('Delete response:', response);
            alert(response);
          }
        },
        error: (err) => {
          console.error('Error deleting user', err);
          alert('Failed to delete user');
        }
      });
    }
  }

  openEditModal(user: any) {
    this.editingUser = { ...user }; // Clone user to avoid direct reference

    // Ensure address object exists with all fields
    if (!this.editingUser.address) {
      this.editingUser.address = {};
    }
    // Initialize potentially missing address fields
    this.editingUser.address.street = this.editingUser.address.street || '';
    this.editingUser.address.city = this.editingUser.address.city || '';
    this.editingUser.address.state = this.editingUser.address.state || '';
    this.editingUser.address.zipcode = this.editingUser.address.zipcode || '';
    this.editingUser.address.country = this.editingUser.address.country || '';

    // Initialize checking/password if not present (though password might be hashed or not returned by backend)
    // Note: If backend doesn't return password, this will be empty, which is fine for "Set new password".
    this.editingUser.password = this.editingUser.password || '';
    this.editingUser.acceptedTermsAndConditions = !!this.editingUser.acceptedTermsAndConditions;

    this.showEditModal = true;
  }

  closeEditModal() {
    this.showEditModal = false;
  }

  updateUser() {
    this.authService.updateUser(this.editingUser.email, this.editingUser).subscribe({
      next: () => {
        const index = this.users.findIndex(u => u.email === this.editingUser.email);
        if (index !== -1) {
          this.users[index] = { ...this.editingUser };
        }
        alert('User updated successfully');
        this.closeEditModal();
      },
      error: (err) => {
        console.error('Error updating user', err);
        alert('Failed to update user');
      }
    });
  }

  onSubmit() {
    this.authService.login(this.credentials).subscribe({
      next: (user) => {
        if (user) {
          console.log('Login successful', user);
          alert('Login Successful! Welcome ' + user.username);
          // this.router.navigate(['/home']);
        } else {
          this.errorMessage = 'Invalid credentials';
        }
      },
      error: (err) => {
        this.errorMessage = 'Login failed. Please check backend connection.';
        console.error(err);
      }
    });
  }
}
