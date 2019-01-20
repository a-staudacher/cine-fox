export interface Person {
  id?: number;
  vorname: string;
  nachname: string;
  dayOfBirth?: Date;
  beschreibung?: string;
  charakter?: Array<any>;
  directors?: Array<any>;
}
