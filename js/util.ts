export class MatchBuilder<R> {
  _state = {};
  _default: (key: string, ...args: any[]) => R = (...args) => null;

  build(): (key: string, ...args: any[]) => R {
    return (key, ...args) => (this._state[key] ? this._state[key](key, ...args) : this._default(key, ...args));
  }

  default(fn: (key) => R): MatchBuilder<R> {
    this._default = fn;
    return this;
  }

  route(key: string, fn: (key: string, ...args: any[]) => R): MatchBuilder<R> {
    this._state[key] = fn;
    return this;
  }
}