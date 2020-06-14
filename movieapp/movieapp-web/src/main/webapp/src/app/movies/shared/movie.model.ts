export class Movie {
  id: number;
  title: string;
  year: number;
  actors: Actor[] = new Array<Actor>();
}

export class Actor {
  id: number;
  name: string;
  rating: number;
}

