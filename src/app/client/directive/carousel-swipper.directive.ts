import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appCarouselSwipper]'
})
export class CarouselSwipperDirective {
  private startX: number = 0;
  private currentX: number = 0;
  private dragging: boolean = false;

  constructor(private el: ElementRef) { }

  @HostListener('mousedown', ['$event'])
  onMouseDown(event: MouseEvent) {
    event.preventDefault();
    this.startX = event.clientX;
    this.dragging = true;
  }


  @HostListener('mousemove', ['$event'])
  onMouseMove(event: MouseEvent) {
    if (this.dragging) {
      event.preventDefault(); 
      this.currentX = event.clientX;
    }
  }

  @HostListener('mouseup', ['$event'])
  onMouseUp(event: MouseEvent) {
    event.preventDefault(); 
    this.dragging = false;
    const diffX = this.startX - this.currentX;

    if (Math.abs(diffX) > 50) { 
      if (diffX > 0) {
        const nextButton = this.el.nativeElement.querySelector('.carousel-control-next');
        if (nextButton) nextButton.click();
      } else {
        const prevButton = this.el.nativeElement.querySelector('.carousel-control-prev');
        if (prevButton) prevButton.click();
      }
    }
    this.startX = 0;
    this.currentX = 0;
  }

  @HostListener('mouseleave', ['$event'])
  onMouseLeave(event: MouseEvent) {
    this.dragging = false;
    this.startX = 0;
    this.currentX = 0;
  }

  


}
