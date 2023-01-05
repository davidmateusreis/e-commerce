import { Component, OnInit } from '@angular/core';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartDetails: any = [];
  displayedColumns: string[] = ['productName', 'description', 'productDiscountedPrice', 'productActualPrice'];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getCartDetails();
  }

  getCartDetails() {
    this.productService.getCartDetails().subscribe(
      (response) => {
        console.log(response);
        this.cartDetails = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
