import { AddressVm } from './address-vm';
import { TelephoneVm } from './telephone-vm';

export class StudentVM {
    studentid:string;
    firstname:string;
    lastname:string;
    studentclass:string;
    address:AddressVm;
    telephones:TelephoneVm[];
}


