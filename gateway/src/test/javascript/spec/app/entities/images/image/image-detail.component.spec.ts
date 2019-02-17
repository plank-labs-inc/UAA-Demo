/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { ImageDetailComponent } from 'app/entities/images/image/image-detail.component';
import { Image } from 'app/shared/model/images/image.model';

describe('Component Tests', () => {
    describe('Image Management Detail Component', () => {
        let comp: ImageDetailComponent;
        let fixture: ComponentFixture<ImageDetailComponent>;
        const route = ({ data: of({ image: new Image(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [ImageDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(ImageDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(ImageDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.image).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
