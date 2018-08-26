/**
 *
 * Asynchronously loads the component for ButtonSearch
 *
 */

import Loadable from 'react-loadable';

export default Loadable({
  loader: () => import('./index'),
  loading: () => null,
});
