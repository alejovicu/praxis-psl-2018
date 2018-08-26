FROM node:8.11.4

COPY ["package.json", "/usr/src/"]

WORKDIR /usr/src

RUN npm install -only=production

COPY [".", "/usr/src/"]

EXPOSE 3001

CMD ["npm", "start"]
