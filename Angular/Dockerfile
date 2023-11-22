FROM node:18.13 AS builder

WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH

COPY package*.json ./
RUN npm install
RUN npm install -g @angular/cli@<version>

COPY . .

RUN ng build 

RUN npm prune --production

EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0"]

