const { merge } = require('webpack-merge');
const common = require('./webpack.common');

const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

module.exports = () =>
  merge(common('development'), {
    mode: 'development',
    devtool: 'inline-source-map',
    devServer: {
      https: true,
      open: true,
      hot: true,
      compress: true,
      port: 3000,
      historyApiFallback: true,
      liveReload: true,
    },
    output: {
      filename: '[name].[contenthash].js',
      publicPath: '/',
    },
    module: {
      rules: [
        {
          test: /\.(sa|sc|c)ss$/i,
          use: ['style-loader', 'css-loader'],
        },
      ],
    },
    plugins: [new BundleAnalyzerPlugin()],
  });
